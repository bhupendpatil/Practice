import time

def gcd(m,n):
    for i in range(1,min(m,n)+1):
        if (m%i==0) and (n%i==0):
            mcrf = i
    return(mcrf)

a = gcd(780000000,6000000000)

print("Gcd is {}".format(a))

end = time.time()

print("Total time for execution is {}".format(end - start))
