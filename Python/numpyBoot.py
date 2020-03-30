import numpy as np

list1 = [0,1,2,3,4]

arr1d = np.array(list1)

list1.append(5)

arr1d + 2

list2 = [[1,1,1,],[2,2,2],[3,3,3]]
arr2d = np.array(list2)

type(arr2d)

arr2d.dtype

arr2d = np.array(list2, dtype="float")

arr2d = arr2d.astype('int')

arr2d.astype('str')

list1.append('6')


np2list = arr2d.tolist()


arr2d.tostring()

arr2d.tobytes()


# dtypes and shape

arr2d = arr2d.astype('float')

print("Shape: ",arr2d.shape)


arr2d.size

arr2d.ndim

arr1d = arr1d * arr1d

arr1d[1]


arr2d[1][0]

boolarr = arr2d < 3


arr2d[boolarr]


arr2d[::-1]



# np.nan, np.inf


arr2d[0][0] = np.nan

arr2d[0][1] = np.inf

np.isnan(arr2d)

np.isinf(arr2d)

missing_flag = np.isnan(arr2d) | np.isinf(arr2d)


# replace inf and nan with 0

arr2d[missing_flag]

arr2d[missing_flag] = 0


# Statistical operations

arr2d.mean()

arr2d.max()

arr2d.min()

arr2d.all()

arr2d.std()

arr2d.var()

arr2d.squeeze()

arr2d.cumsum()

arr = arr2d[:2,:2]


arr2d[1:3,1:3]

arr2d.reshape(9,1)

arr2d.reshape(1,9)

a = arr2d.flatten()

b = arr2d.ravel()

b[0] = -1


# sequence, repetitions and random numbers


np.arange(1,5)

np.arange(1,5, dtype='int')

np.arange(2,50,2)

np.linspace(1,50,100)

np.logspace(1,50,10)

np.zeros([2,2])

np.ones([2,2])

a = [1,2,3]

np.tile(a,3)

np.repeat(a,3)

np.repeat(arr2d,3)


# random number

np.random.rand(1,3)

np.random.randn(1,3)

np.random.randint(0,10,[3,3])

np.random.seed(0)
np.random.randint(0,10,[3,3])

np.unique(arr2d)


uniques, counts = np.unique(arr2d,return_counts=True)

uniques

counts



# more 


arr = np.array([8,94,8,56,1,3,4,5,7])


index_gt10 = np.where(arr>10)

arr[index_gt10]

arr[arr>10]

arr>10

np.where(arr>10,'gt10','lt5')

arr.argmax()

arr.argmin()


# read and write csv file

data = np.genfromtxt("https://raw.githubusercontent.com/selva86/datasets/master/Auto.csv",delimiter=",",skip_header=1,filling_values=-1000,dtype="float")

data.shape
np.set_printoptions(suppress=True)
data[:3]

data2 = np.genfromtxt("https://raw.githubusercontent.com/selva86/datasets/master/Auto.csv", delimiter=",",skip_header=1,dtype=None)
data2[:3]


np.savetxt('data.csv',data,delimiter=',')
np.save('data.npy',data)
np.savez('data.npz',data,data2)


d = np.load('data.npy')

d2 = np.load('data.npz')

d2.files

d2['arr_1']

# concat wih rows and col wise

arr1 = np.zeros([4,4])
arr2 = np.ones([4,4])

# ver
np.concatenate([arr1,arr2],axis=0)
np.vstack([arr1,arr2])
np.r_[arr1,arr2]

#hor
np.concatenate([arr1,arr2],axis=1)

np.hstack([arr1,arr2])

np.c_[arr1,arr2]


# sort a numpy array

arr = np.random.randint(1,10,size=[10,5])

np.sort(arr,axis=0)

sorted_index = arr[:,0].argsort()


arr[sorted_index]


# working with dates


d = np.datetime64('2019-06-02 23:10:00')

d

d+1

d+1000

oneday = np.timedelta64(1,'D')

oneminute = np.timedelta64(1,'m')

dates = np.arange(np.datetime64('2019-06-02'),np.datetime64('2020-06-02'))


# Advance function


def foo(x):
    if x%2==1:
        return x**2
    else:
        return x/2
    
foo(10)

foo_v = np.vectorize(foo,otypes=[float])

foo_v(arr)

