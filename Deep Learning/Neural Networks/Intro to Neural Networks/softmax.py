import numpy as np

# Write a function that takes as input a list of numbers, and returns
# the list of values given by the softmax function.
def softmax(L):
    softmaxList = []
    for i in np.exp(L):
        softmaxList.append(i*1.0/sum(np.exp(L)))
    return softmaxList
