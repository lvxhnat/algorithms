import numpy as np

# Basic Gradient Descent

sigmoid = lambda x: 1 / (1 + np.exp(-x))
sigmoid_dx = lambda x: sigmoid(x) * (1 - sigmoid(x))
mse = lambda pred, target: ((target - pred) ** 2).mean()
mse_dx = lambda pred, target: -(target - pred)

input_data = np.array(
    [[1, 0, 1], [0, 1, 1], [0, 0, 1], [1, 1, 1], [0, 1, 1], [1, 0, 1]]
)
target_data = np.array([0, 1, 0, 1, 1, 0])
weights = np.array([0.1, 0.1, 0.1])
alpha = 0.1  # Learning rate
epochs = 30

for epoch in range(epochs):
    sum_loss = 0
    weight_updates = np.zeros(weights.shape)
    for i in range(len(target_data)):  # Iterate over each sample
        # Front propagation
        raw_predictions = input_data[i].dot(weights)
        predictions = sigmoid(raw_predictions)  # Activation layer
        sum_loss += mse(predictions, target_data[i])  # Monitor the loss
        # Back propagation portion. Here we use the derivatives
        error = mse_dx(predictions, target_data[i])
        dx = error * sigmoid_dx(raw_predictions)
        weight_updates += dx * input_data[i]

    # This is our gradient descent portio
    weights -= (alpha / len(target_data)) * weight_updates

    average_loss = sum_loss / len(target_data)
    print(f"Error for epoch {epoch} is {average_loss}")
