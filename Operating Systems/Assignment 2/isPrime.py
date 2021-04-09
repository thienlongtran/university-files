import math
import time
import multiprocessing
import threading
import itertools

class numPosition(object):
    def __init__(self):
        self.lock = threading.Lock()
        self.currentNum = 2
    
    def get(self):
        return self.currentNum
    
    def getAndIncrement(self):
        with self.lock:
            self.currentNum = self.currentNum + 1
            return (self.currentNum - 1)

startNum = numPosition()
a = 0

def isPrimeThread(isPrime, sqrtN, num):
    #global startNum
    #while startNum.get() <= 20 and isPrime == False:
    #    print("%s, %s" %(startNum.getAndIncrement(), num))

    global a

    while a < 20:
        a = a + 1
        print("%s %s" %(a, num))

if __name__ == "__main__":
    cont = itertools.count()
    n = 11195272402559239
    sqrtN = int(math.ceil(math.sqrt(n)))
    isPrime = False
    startNum = 0

    tStart = time.time()

    thread1 = multiprocessing.Process(target = isPrimeThread, args=(isPrime, sqrtN, "1" ))
    thread1.start()
    thread2 = multiprocessing.Process(target = isPrimeThread, args=(isPrime, sqrtN, "2"))
    thread2.start()

    """
    for i in range(2, sqrtN+1):
        if n % i == 0:
            print("%s is not a prime number" % n)

    else:
        print("%s is a prime number" % n)
    """

    thread1.join()
    thread2.join()
    tEnd = time.time()
    print("Elapsed Time: %.2f seconds" %(tEnd - tStart))

