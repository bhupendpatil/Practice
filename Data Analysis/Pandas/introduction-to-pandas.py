import pandas as pd

# 2 main datatypes
# ` Series
# ` DataFrame

# car_type : 1-dimensional(Series)
car_type = pd.Series(['SUV','Diesel','Petrol','Small'])
car_type    #use print(car_type) if you want to run this in IDLE

# colors : 1-dimensional(Series)
colors = pd.Series(['Red','Blue','Green','Black'])
colors

# car_data : multi-dimensional(DataFrame)
car_data = pd.DataFrame({'Car Type': car_type, 'Color': colors})
car_data

# import data
car_sale = pd.read_csv("car-sales.csv")
car_sale

# export data
car_sale.to_csv("exported-car-sales.csv",index=False)

exported_car_sales = pd.read_csv("exported-car-sales.csv")
exported_car_sales


# Describe data
# Attributes
car_sale.dtypes

car_sale.columns

car_column = car_sale.columns
car_column

car_sale.index

# Functions
car_sale.describe()

car_sale.info()

car_sale.mean()

car_price = pd.Series([2000,22223,232233,2323])
car_price.mean()

car_sale.sum()

car_sale["Odometer (KM)"].sum()

len(car_sale)


# Viewing and selecting data
car_sale.head()
car_sale.head(7)

car_sale.tail()
car_sale.tail(2)

# .loc and .iloc
animals = pd.Series(["dog","cat","mouse","lion","tiger","cheeta"],index=[0,4,3,2,3,4])
animals

# loc refers to index
animals.loc[4]
car_sale.loc[3]

# iloc refers to position
animals.iloc[4]
car_sale.iloc[5]

animals[:3]
car_sale[:3]

#both are same
car_sale["Make"]
car_sale.Make

#search filter
#shows all Toyota records
car_sale[car_sale.Make == "Toyota"]

car_sale[car_sale["Odometer (KM)"] > 100000]

pd.crosstab(car_sale["Make"],car_sale["Doors"])

# groupby
car_sale.groupby(["Make"]).mean()

car_sale.groupby(["Colour"]).mean()

%matplotlib inline
import matplotlib.pyplot as plt

car_sale["Odometer (KM)"].plot()

car_sale["Odometer (KM)"].hist()

car_sale["Price"].plot()

car_sale["Price"] = car_sale["Price"].str.replace('[\$\,]','').astype(int) / 100

car_sale

car_sale["Price"].plot()


# Manipulating Data
# lower
car_sale["Make"].str.lower()

# assigns
car_sale["Make"] = car_sale["Make"].str.lower()

#same as
car_sale_missing["Odometer"].fillna(car_sale_missing["Odometer"].mean(),inplace=True)
car_sale_missing["Odometer"]
car_sale_missing["Odometer"] = car_sale_missing["Odometer"].fillna(car_sale_missing["Odometer"].mean())
car_sale_missing["Odometer"]

# drop na values
car_sale_missing.dropna()
car_sale_missing_dropped = car_sale_missing.dropna()
car_sale_missing_dropped

car_sale_missing_dropped.to_csv("car-sale-missing-dropped.csv")


# Column from series
# Column from series
seat_column = pd.Series([5,5,5,5,5])

# New seats column
car_sale["Seats"] = seat_column
car_sale

car_sale["Seats"].fillna(5,inplace=True)
car_sale

# column using python list
fuel_economy = [7.5,9.2,5.0,9.6,8.7,4.7,7.6,8.7,3.0,4.5]
car_sale["Fuel per 100KM"] = fuel_economy
car_sale

car_sale["Total fuel used"] = car_sale["Odometer (KM)"]/100 * car_sale["Fuel per 100KM"]
car_sale

car_sale["Total fuel used (L)"] = car_sale["Odometer (KM)"]/100 * car_sale["Fuel per 100KM"]
car_sale

#using single value
car_sale["Number of wheels"] = 4
car_sale

car_sale["Passed road safety"] = True
car_sale

# drop
car_sale.drop("Total fuel used", axis=1)

# shuffle
car_sale_shuffled = car_sale.sample(frac=1)
car_sale_shuffled

# Only 20% of data
car_sale_shuffled.sample(frac=0.2)

# reset index
car_sale_shuffled.reset_index(drop=True,inplace=True)
car_sale_shuffled

# apply
car_sale["Odometer (KM)"] = car_sale["Odometer (KM)"].apply(lambda x: x/1.6)
car_sale

#rename
car_sale.rename(columns={"Odometer (KM)": "Odometer (Mile)"},inplace=True)
car_sale
