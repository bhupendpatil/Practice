import tensorflow as tf

# one way
hello_constant = tf.constant("Hello World!")
tf.print(hello_constant)

"""
Output:
Hello World!
"""

# another way
tf.compat.v1.disable_eager_execution()
hello = tf.constant("Hello, Bhupend!")
sess = tf.compat.v1.Session()
print(sess.run(hello))

"""
Output:
b'Hello, Bhupend!'
"""
