"""
Setup the strides, padding and filter weight/bias such that
the output shape is (1, 2, 2, 3).
"""
import tensorflow as tf
import numpy as np

# `tf.nn.conv2d` requires the input be 4D (batch_size, height, width, depth)
# (1, 4, 4, 1)
x = np.array([
    [0, 1, 0.5, 10],
    [2, 2.5, 1, -8],
    [4, 0, 5, 6],
    [15, 1, 2, 3]], dtype=np.float32).reshape((1, 4, 4, 1))
X = tf.constant(x)


def conv2d(input,strides,height,width,input_depth,output_depth):
    # Filter (weights and bias)
    # The shape of the filter weight is (height, width, input_depth, output_depth)
    # The shape of the filter bias is (output_depth,)
    # TODO: Define the filter weights `F_W` and filter bias `F_b`.
    # NOTE: Remember to wrap them in `tf.Variable`, they are trainable parameters after all.
    F_W = tf.Variable(tf.truncated_normal((height,width,input_depth,output_depth)))
    F_b = tf.Variable(tf.zeros(output_depth))
    # TODO: Set the stride for each dimension (batch_size, height, width, depth)
    strides = strides
    # TODO: set the padding, either 'VALID' or 'SAME'.
    padding = "VALID"
    # https://www.tensorflow.org/versions/r0.11/api_docs/python/nn.html#conv2d
    # `tf.nn.conv2d` does not include the bias computation so we have to add it ourselves after.
    return tf.nn.conv2d(input, F_W, strides, padding) + F_b

# (1,4,4,1) (1,2,2,3)
stridess = [1, 2, 2, 3]
in_height = 4
in_width = 4
filter_height = 2
filter_width = 2
input_depth = 1
output_depth = 3
height = int(np.ceil((in_height - filter_height + 1)/(stridess[1])))
width = int(np.ceil((in_width - filter_width + 1)/(stridess[2])))

out = conv2d(X,stridess,height,width,input_depth,output_depth)

print(out)

"""
Output:
Tensor("add:0", shape=(1, 2, 2, 3), dtype=float32)
"""
