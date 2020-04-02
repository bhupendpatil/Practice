import seaborn as sns
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
%matplotlib inline

sns.set(style="darkgrid")


tips = sns.load_dataset('tips')
tips.head()
tips.tail()

#relplot

sns.relplot(x='total_bill',y='tip',data=tips)

sns.relplot(x='total_bill',y='tip',data=tips,hue='smoker')

sns.relplot(x='total_bill',y='tip',data=tips,hue='smoker',style="time")

sns.relplot(x='total_bill',y='tip',hue='size',data=tips)

sns.relplot(x="total_bill",y='tip',hue='size',data=tips,palette='ch:r=-0.8,l=0.95')


sns.relplot(x='total_bill',y='tip',size='size',data=tips,sizes=(15,200))

from numpy.random import randn

df = pd.DataFrame(dict(time=np.arange(500),value=randn(500).cumsum()))

df.head()

sns.relplot(x='time',y='value',kind='line',data=df,sort=True)

df = pd.DataFrame(randn(500,2).cumsum(axis=0),columns=['time','value'])

df.head()

sns.relplot(x='time',y='value',kind='line',data=df,sort=False)

