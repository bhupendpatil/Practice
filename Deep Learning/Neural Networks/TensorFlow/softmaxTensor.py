import tensorflow as tf

def run():
    output = None
    logit_data = [2.0,1.0,0.1]
    logits = tf.placeholder(tf.float32)
    
    softmax = tf.nn.softmax(logits)
    
    with tf.Session() as sess:
        output = sess.run(softmax, {logits:logit_data})
    return output

print(run())

"""
Output:
[0.6590012  0.24243298 0.09856589]
"""
