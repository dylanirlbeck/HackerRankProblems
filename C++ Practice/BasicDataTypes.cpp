#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int in;
    long lo;
    char ch;
    float fl;
    double d;
    scanf("%d %ld %c %f %lf", &in, &lo, &ch, &fl, &d);
    printf("%d\n%ld\n%c\n%f\n%lf", in, lo, ch, fl, d);
    return 0;
}
