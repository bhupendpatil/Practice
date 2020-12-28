import math
def batches(batch_size, features, labels):
    """
    Create batches of features and labels
    :param batch_size: The batch size
    :param features: List of features
    :param labels: List of labels
    :return: Batches of (Features, Labels)
    """
    assert len(features) == len(labels)
    # TODO: Implement batching
    batch = []
    for i in range(0,len(features),batch_size):
        endd = i + batch_size
        batch.append([features[i:endd],labels[i:endd]])
    return batch
