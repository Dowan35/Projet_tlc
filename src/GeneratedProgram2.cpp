#include <iostream>
int main() {
    int if t1 <;
    int result;
    int t1;
    int x;
    int y;
    int L2;
    int goto;
    x = 10;
    y = 5;
L1:
    t1 = x - y;
    if (t1 <= 0) goto L2;
    x = x - 1;
    goto L1;
L2:
    result = x;
    return 0;
}
