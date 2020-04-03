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


sns.relplot(x='timepoint',y='signal',kind='line',data=fmri)


sns.relplot(x='timepoint',y='signal',kind='line',data=fmri,ci=False)

sns.relplot(x='timepoint',y='signal',estimator=None,kind='line',data=fmri)

sns.relplot(x='timepoint',y='signal',kind='line',hue='event',data=fmri)

sns.relplot(x='timepoint',y='signal',hue='region',style='event',kind='line',data=fmri)

sns.relplot(x='timepoint',y='signal',hue='region',style='event',kind='line',data=fmri,markers=True,dashes=False)

sns.relplot(x='timepoint',y='signal',hue='region',units='subject',estimator=None,kind='line',data=fmri.query("event=='stim'"))

sns.relplot(x='time',y='firing_rate',data=dots,kind='line')

sns.relplot(x='time',y='firing_rate',data=dots,hue='coherence',kind='line',style='choice')

palette = sns.cubehelix_palette(light=0.8,n_colors=6)

sns.relplot(x='time',y='firing_rate',data=dots,hue='coherence',kind='line',style='choice',palette=palette)

sns.relplot(x='time',y='firing_rate',size='coherence',style='choice',kind='line',data=dots,sizes=(1,5))

sns.relplot(x='time',y='firing_rate',size='coherence',style='choice',hue='coherence',kind='line',data=dots,sizes=(1,5))


df = pd.DataFrame(dict(time=pd.date_range('2019-06-02',periods=500),value=randn(500).cumsum()))

g = sns.relplot(x='time',y='value',kind='line',data=df)
g.fig.autofmt_xdate()

sns.relplot(x='total_bill',y='tip',hue='smoker',col='time',data=tips)

sns.relplot(x='total_bill',y='tip',hue='smoker',col='size',data=tips)

sns.relplot(x='total_bill',y='tip',hue='smoker',row='size',data=tips)

sns.relplot(x='timepoint',y='signal',hue='subject',col='region',row='event',height=3,kind='line',estimator=None,data=fmri)


sns.relplot(x='total_bill',y='tip',hue='smoker',col='size',data=tips,col_wrap=3,height=3)

