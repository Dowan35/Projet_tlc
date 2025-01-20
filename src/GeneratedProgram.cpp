#include <iostream>
int main() {
    int x = 10;
    int y = 5;
    L1:
    int t1 = x - y;
    if (t1 <= 0) goto L2;
    x = x - 1;
    goto L1;
    L2:
    int result = x;
    return 0;
}
