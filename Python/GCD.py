import time

def gcd(m,n):
    fm = []
    for i in range(1,m+1):
        if(m%1==0):
            fm.append(i)

    fn = []
    for j in range(1,n+1):
        if(n%1==0):
            fn.append(j)

    cf = []
    for f in fn:
        if f in fm:
            cf.append(f)

    return(cf[-1])



a = gcd(780000000,6000000000)

print("Gcd is {}".format(a))

end = time.time()

print("Total time for execution is {}".format(end - start))