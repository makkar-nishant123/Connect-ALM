It will For connecting to ALM on 32 bit

For 64 Bit , Try following before Execution 

a. Copy the OTAClient.dll and WebClient.dll from C:\Users\MYACC\AppData\Local\HP\ALM-Client\10 and save it in Windows/System32 folder.

b. After following the step 2, you must have a com4j-x86.dll in the location where tlbimp.jar is present. Now copy that dll to Windows/System32 folder.

c. Now with Admin rights, register all 3 dll files using the commands 1 by 1 as follows.




