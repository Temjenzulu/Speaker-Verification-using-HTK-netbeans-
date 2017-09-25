mkdir ./HMM_trained_model_state_5
for((i=0;i<=32;i++))
do
mkdir ./HMM_trained_model_state_5/hmm$i
done

cat ./mix_1.hed | sed s/MU\ 1/MU\ 2/g | sed  's/state\[2\]/state\[2-8\]/g' >  ./HMM_trained_model_state_5/mix_2.hed

for((i=3;i<=32;i++))
do
cat ./HMM_trained_model_state_5/mix_$((i-1)).hed | sed s/MU\ $((i-1))/MU\ $i/g  > ./HMM_trained_model_state_5/mix_$i.hed
done

#Calculating the global mean and the variance according to the proto given
#rm ./HMM_trained_model_state_5/hmm*/*
HCompV -T 1 -D -A -C ./analysis_train.conf -I ./train.mlf -f 0.01 -m -S ./train.list -M ./HMM_trained_model_state_5/hmm0 ./proto.txt


#generates the  hmmdefs and macros for hmm0 using generated proto and vfloors files

file="/home/zzzz/NetBeansProjects/AVSYSTEM/HMM_Based_Speaker_Identification/hmmlist.txt"
while IFS= read line
do
cat ./HMM_trained_model_state_5/hmm0/proto | sed -e '1,3d' | sed s/proto/"$line"/g >> ./HMM_trained_model_state_5/hmm0/hmmdefs
done <"$file"



cat ./HMM_trained_model_state_5/hmm0/proto | sed -n 1,3p > ./HMM_trained_model_state_5/hmm0/macros
cat ./HMM_trained_model_state_5/hmm0/vFloors >> ./HMM_trained_model_state_5/hmm0/macros

#HMM training

for((i=1;i<=2;i++))
do
HERest -T 1 -D -A -C ./analysis_train.conf -I ./train.mlf -t 250.0 150.0 1000.0 -S ./train.list -H ./HMM_trained_model_state_5/hmm0/macros -H ./HMM_trained_model_state_5/hmm0/hmmdefs -M ./HMM_trained_model_state_5/hmm1  ./hmmlist.txt
done

# training with different no.of mixtures
for((i=2;i<=32;i++))
do
#Incrementing mixture size
HHEd -T 1 -D -A  -C ./analysis_train.conf -H ./HMM_trained_model_state_5/hmm$((i-1))/macros -H ./HMM_trained_model_state_5/hmm$((i-1))/hmmdefs -M ./HMM_trained_model_state_5/hmm$i  ./HMM_trained_model_state_5/mix_$i.hed  ./hmmlist.txt 
# Iterations
for((j=1;j<=6;j++))
do
HERest -T 1 -D -A -C ./analysis_train.conf -I ./train.mlf -t 250.0 150.0 1000.0  -S ./train.list -H ./HMM_trained_model_state_5/hmm$i/macros -H ./HMM_trained_model_state_5/hmm$i/hmmdefs -M ./HMM_trained_model_state_5/hmm$i ./hmmlist.txt
done

done
