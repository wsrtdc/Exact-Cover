# Exact-Cover
AlgX.java: Java implementation of the exact cover problem in only 28 lines.

Modified Algorithm X in minimal implementation, pretty small and hopefully comprehensible and comprehensive. Short explications can be found in doc.pdf.

AlgXMain.java contains some examples, the output is as follows (last 2 lines are a Sudoku puzzle, input and output):

```
001
011
101
110
Solution: [0, 3]

0010110
1001001
0110010
1001000
0100001
0001101
Solution: [0, 3, 4]

1001001
1001000
0001101
0010110
0110011
0100001
Solution: [1, 3, 5]

111
000
111
Solution: [0]
Solution: [2]

111010
110000
000101
001101
001010
Solution: [0, 2]
Solution: [1, 2, 4]

000000010400000000020000000000050407008000300001090000300400200050100000000806000
693784512487512936125963874932651487568247391741398625319475268856129743274836159

```
