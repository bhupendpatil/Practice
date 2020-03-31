import matplotlib.pyplot as plt
import numpy as np
from numpy.random import randint

%matplotlib inline

x = np.linspace(0,20,20)

y = randint(1,50,20)

y.size

plt.plot(y)

print(np.sort(y))

y = np.sort(y)


plt.plot(y)

plt.plot(x,y)


plt.plot(x,y,'b')

plt.plot(x,y,color="g")
plt.ylabel("Y Axis")
plt.xlabel("X Axis")
plt.title("Random")
plt.show()


# Subplot

y2 = y*x
plt.subplot(1,2,1)
plt.plot(x,y,'ro-',markersize=6)
plt.subplot(1,2,2)
plt.plot(x,y2,'b*-')


# oo plots

fig = plt.figure()
axes = fig.add_axes([0.1,0.1,1,1])

axes.plot(x,y,'r')
axes.set_xlabel("X")
axes.set_ylabel("Y")
axes.set_title("Random")


fig = plt.figure()
ax1 = fig.add_axes([0,0,1,1])
ax2 = fig.add_axes([0.1,0.6,0.4,0.3])

ax1.plot(x,y,'r')
ax1.set_xlabel('X')
ax1.set_ylabel('Y')
ax1.set_title('Y plot')

ax2.plot(x,y2,'g')
ax2.set_xlabel('X')
ax2.set_ylabel('Y')
ax2.set_title('Y2 plot')


# subplots

fig, ax = plt.subplots(1,2)

ax[0].plot(x,y,'b')
ax[1].plot(x,y,'r')

fig,ax = plt.subplots(1,2)

col = ['r','b']
data = [y,y2]

for i,j in enumerate(ax):
    j.plot(x,data[i],col[i])

fig.tight_layout()


# change figure size

fig,ax = plt.subplots(figsize=(8,6),dpi=100)
ax.plot(x,y,'r')
ax.set_xlabel('x')
ax.set_ylabel('y')
ax.set_title('Random Number')
fig.savefig('random.png',api=100)


# legend label and name

fig,ax = plt.subplots(figsize=(8,6),dpi=100)
ax.plot(x,y,'r', label="y")
ax.plot(x,y2,'b', label="y*x")
ax.set_xlabel('x')
ax.set_ylabel('y')
ax.set_title('Random Number')
ax.legend(loc=5)
fig.savefig('random.png',api=100)


# style and color

fig,ax = plt.subplots()
ax.plot(x,y,'b1--',markersize=12,linewidth=3)


# plot range

fig, ax = plt.subplots(1,3,figsize=(12,4))

ax[0].plot(x,y,x,y2)

ax[1].plot(x,y**2,'k')
ax[1].set_ylim([0,500])

ax[2].plot(x,y,x,y2)
ax[2].set_ylim([0,100])
ax[2].set_xlim([1,4])


# plot types

plt.scatter(x,y)
plt.bar(x,y)

from random import sample
data = sample(range(1,10000),10)
data
plt.hist(data,rwidth=0.8)

data = [np.random.normal(0,std,100) for std in range(1,10)]
plt.boxplot(data,vert=True,patch_artist=True)
plt.show()


# log scale

fig, ax = plt.subplots(1,2,figsize=(10,4))
ax[0].plot(x,y,x,y2)

ax[1].plot(x,np.exp(x))
ax[1].set_yscale('log')
fig.tight_layout()


# ticks


fig,ax = plt.subplots(figsize=(10,5))
ax.plot(x,y2)
ax.set_xticks([1,10])
ax.set_xticklabels(['a','b'],fontsize=10)

ax.set_yticks([0,10,100,1000])


# formatter

from matplotlib import ticker

fig,ax = plt.subplots()
ax.plot(x,y2)
ax.set_title("Sci-fi")

formatter = ticker.ScalarFormatter(useMathText=True)
formatter.set_scientific(True)
formatter.set_powerlimits((-3,-1))
ax.yaxis.set_major_formatter(formatter)