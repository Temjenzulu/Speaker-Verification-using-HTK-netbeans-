 #!/bin/bash
cd /home/zzzz/Desktop/KICHUHTK;
line=$(head -n 1 line1)
./RemoveEndSilence $line temp 44
sox -t raw -b 16 -e signed-integer -r 16000 -c 1 temp $line


