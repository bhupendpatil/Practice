# Series Objects
import pandas as pd

data = [1,2,3,4]
series1 = pd.Series(data)
series1

type(series1)


# changing index of aa series object
series1 = pd.Series(data,index=['a','b','c','d'])
series1

# create a dataframe using list
import pandas as pd

data=[1,2,3,4,5]
df = pd.DataFrame(data)
df

# create a dataframe using dict
dictionary = {'fruits':['apples','bananas','mangoes'],
              'count':[10,20,15]}
df = pd.DataFrame(dictionary)
df

# create a dataframe using series
series = pd.Series([6,12],index=['a','b'])
df = pd.DataFrame(series)
df

# create a dataframe using numpy array
import numpy as np

numpyarray = np.array([[50000,60000],['John','James']])
df = pd.DataFrame({'name':numpyarray[1],'salary':numpyarray[0]})
df


# Merge Operation
import pandas as pd
player = ['Player1','Player2','Player3']
point = [8,9,6]
title = ['Game1','Game2','Game3']
df1 = pd.DataFrame({'Player':player,'Points':point,'Title':title})
df1
player = ['Player1','Player5','Player6']
power = ['Puch','Kick','Elbow']
title = ['Game1','Game5','Game6']
df2 = pd.DataFrame({'Player':player,'Power':power,'Title':title})
df2


# Inner Merge
df1.merge(df2,on='Title',how='inner')
df1.merge(df2,on='Player',how='inner')

# Left Merge
df1.merge(df2,on='Player',how="left")

# Right Merge
df1.merge(df2,on='Player',how="right")

# Outer Merge
df1.merge(df2,on='Player',how="outer")


# Join Operation
player = ['Player1','Player2','Player3']
point = [8,9,6]
title = ['Game1','Game2','Game3']
df3 = pd.DataFrame({'Player':player,'Points':point,'Title':title},index=['L1','L2','L3'])
df3

player = ['Player1','Player5','Player6']
power = ['Puch','Kick','Elbow']
title = ['Game1','Game5','Game6']
df4 = pd.DataFrame({'Players':player,'Power':power,'Titles':title},index=['L2','L3','L4'])
df4

# inner join
df3.join(df4,how='inner')

# left join
df3.join(df4,how='left')

# right join
df3.join(df4,how='right')

# outer join
df3.join(df4,how='outer')


# concatenate

pd.concat([df3,df4])



# importing and analyzing the Dataset
import pandas as pd

cars = pd.read_csv("mtcars.csv")
cars

type(cars)

cars.head()
cars.head(10)

cars.tail()
cars.tail(10)

cars.shape

cars.info(null_counts=True)

cars.mean()

cars.median()

cars.std()

cars.max()

cars.min()

cars.count()

cars.describe()


# cleaning dataset

# filter
cars = cars.rename(columns={'model1':'model'})

cars.qsec = cars.qsec.fillna(cars.qsec.mean())

cars = cars.drop(columns=['S.No'])

df = cars[['mpg','cyl','disp','hp','drat','wt','qsec','vs','am','gear','carb']].corr()
df

cars.mpg = cars.mpg.astype(float)
cars.info(null_counts=True)


# manipluating

cars.iloc[:,4]
cars.iloc[0:5,4]

cars.iloc[:,:]

cars.iloc[4:,4:]

cars.iloc[:,1]

cars.loc[:,'mpg']
cars.loc[6,'mpg']

cars.loc[6,'mpg':'qsec']

cars['am'] = 1

f = lambda x : x*2
cars['am'] = cars['am'].apply(f)
cars

cars.sort_values(by='cyl')

cars.sort_values(by='cyl', ascending=False)

cars['cyl'] > 6

filt1 = cars['cyl'] > 6

filt2 = cars[filt1]

filt2


filt3 = (cars['cyl'] > 6) & (cars['hp'] > 300)

filt4 = cars[filt3]

filt4