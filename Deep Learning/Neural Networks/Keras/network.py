import numpy as np
from keras.models import Sequential
from keras.layers.core import Dense, Activation

# Set random seed
np.random.seed(42)

# Our data
X = np.array([[0, 0], [0, 1], [1, 0], [1, 1]]).astype('float32')
y = np.array([[0], [1], [1], [0]]).astype('float32')

# Initial Setup for Keras
# One-hot encoding the output
y = np_utils.to_categorical(y)

# Building the model
xor = Sequential()

# Add required layers
# xor.add()
xor.add(Dense(32, input_dim=2))
xor.add(Activation('tanh'))
xor.add(Dense(2))
xor.add(Activation('sigmoid'))


# Specify loss as "binary_crossentropy", optimizer as "adam",
# and add the accuracy metric
xor.compile(loss="binary_crossentropy", optimizer="adam", metrics=["accuracy"])

# Uncomment this line to print the model architecture
xor.summary()

# Fitting the model
history = xor.fit(X, y, epochs=50, verbose=0)

# Scoring the model
score = xor.evaluate(X, y)
print("\nAccuracy: ", score[-1])

# Checking the predictions
print("\nPredictions:")
print(xor.predict_proba(X))

"""
Output:
Model: "sequential_5"
_________________________________________________________________
Layer (type)                 Output Shape              Param #   
=================================================================
dense_8 (Dense)              (None, 32)                96        
_________________________________________________________________
activation_8 (Activation)    (None, 32)                0         
_________________________________________________________________
dense_9 (Dense)              (None, 2)                 66        
_________________________________________________________________
activation_9 (Activation)    (None, 2)                 0         
=================================================================
Total params: 162
Trainable params: 162
Non-trainable params: 0
_________________________________________________________________
1/1 [==============================] - 0s 277ms/step - loss: 0.6915 - accuracy: 0.5000

Accuracy:  0.5

Predictions:
[0 1 0 1]
"""
