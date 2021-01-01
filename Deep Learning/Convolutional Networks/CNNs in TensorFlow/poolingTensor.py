"""
Set the values to `strides` and `ksize` such that
the output shape after pooling is (1, 2, 2, 1).
"""
import tensorflow as tf
import numpy as np

# `tf.nn.max_pool` requires the input be 4D (batch_size, height, width, depth)
# (1, 4, 4, 1)
x = np.array([
    [0, 1, 0.5, 10],
    [2, 2.5, 1, -8],
    [4, 0, 5, 6],
    [15, 1, 2, 3]], dtype=np.float32).reshape((1, 4, 4, 1))
X = tf.constant(x)

def maxpool(input):
    # TODO: Set the ksize (filter size) for each dimension (batch_size, height, width, depth)
    ksize = [1,2,2,1]
    # TODO: Set the stride for each dimension (batch_size, height, width, depth)
    strides = [1,2,2,1]
    # TODO: set the padding, either 'VALID' or 'SAME'.
    padding = "VALID"
    # https://www.tensorflow.org/versions/r0.11/api_docs/python/nn.html#max_pool
    return tf.nn.max_pool(input, ksize, strides, padding)
    
out = maxpool(X)

print(out)
"""
Output:
tf.Tensor(
[[[[ 2.5]
   [10. ]]

  [[15. ]
   [ 6. ]]]], shape=(1, 2, 2, 1), dtype=float32
"""

print(out[0,0,0])    
"""
Output:
tf.Tensor([2.5], shape=(1,), dtype=float32)
"""

print(out[0,0,1])
"""
Output:
tf.Tensor([10.], shape=(1,), dtype=float32)
"""

print(out[0,1,0])
"""
Output:
tf.Tensor([15.], shape=(1,), dtype=float32)
"""

print(out[0,1,1])
"""
Output:
tf.Tensor([6.], shape=(1,), dtype=float32)
"""
