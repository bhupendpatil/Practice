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

