#!/bin/bash

      




cd /home/zzzz/Desktop/KICHUHTK;

HVite -T 1 -H /home/zzzz/NetBeansProjects/AVSYSTEM/HMM_Based_Speaker_Identification/HMM_trained_model_state_5/hmm14/hmmdefs -S /home/zzzz/Desktop/KICHUHTK/test.txt -C /home/zzzz/Desktop/KICHUHTK/identification/conf -i /home/zzzz/Desktop/KICHUHTK/recount_test.mlf -w /home/zzzz/Desktop/KICHUHTK/identification/wdnet.txt -p 10.0 -s 0 /home/zzzz/Desktop/KICHUHTK/identification/dict.txt /home/zzzz/Desktop/KICHUHTK/identification/hmmlist.txt >& identity.log





