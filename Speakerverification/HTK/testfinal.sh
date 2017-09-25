#!/bin/bash



# here exp_name indicates the number of states

cd /home/zzzz/Desktop/KICHUHTK;


line=$(head -n 1 id.txt)
echo $line
HVite -T 1 -H /home/zzzz/Desktop/KICHUHTK/split10/hmmdefs_"$line".txt -S /home/zzzz/Desktop/KICHUHTK/test.txt -C /home/zzzz/Desktop/KICHUHTK/verification/hanalysis.conf -i /home/zzzz/Desktop/KICHUHTK/verification/recount_test.mlf -w /home/zzzz/Desktop/KICHUHTK/wdnets/wdnet_"$line".txt -p 10.0 -s 0 /home/zzzz/Desktop/KICHUHTK/dicts/dict_"$line" /home/zzzz/Desktop/KICHUHTK/hmms/hmm_"$line" >& likelihood.log




