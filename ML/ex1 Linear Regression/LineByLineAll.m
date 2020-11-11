clear;

% - Warm up exercise -
disp('warmUpExercise()');
disp(warmUpExercise());


% - Plotting the data - 
disp('Plotting the data');
data = load('ex1data1.txt');
disp('ex1data1.txt loaded');
X = data(:, 1); 
y = data(:, 2);
disp('X and y set');
disp('plotData(X,y)');
plotData(X,y);

% - Gradient Descent - 
m = length(X);
X = [ones(m,1),data(:,1)];
theta = zeros(2, 1);
iterations = 1500;
alpha = 0.01;
disp('m, X, theta, iterations and alpha set');

%Computing the cost 
disp('Computing the cost');
disp('computeCost(X, y, theta)');
disp(computeCost(X, y, theta));
disp('computeCost(X, y,[-1; 2])');
disp(computeCost(X, y,[-1; 2]));

%Gradient descent
disp('Compute theta');
theta = gradientDescent(X, y, theta, alpha, iterations);
fprintf('theta computed from gradient descent: \n%f,\n%f \n',theta(1),theta(2));

%Plot the linear fit
hold on;
disp("plot(X(:,2),X*theta,'-')");
plot(X(:,2),X*theta,'g');
disp('adding legend');
legend('Training data','Linear regession');
hold off;

%values for population sizes of 35k and 70k
predict1 = [1,3.5] * theta;
predict2 = [1,7] * theta;
fprintf('For population = 35k, we predict a profit of %f\n', predict1*10000);
fprintf('For population =70k, we predict a profit of %f\n', predict2*10000);


% Visualizing J(theta_0, theta_1):
theta0_vals = linspace(-10, 10, 100);
theta1_vals = linspace(-1, 4, 100);
disp('theta0_vals and theta1_vals set');
J_vals = zeros(length(theta0_vals), length(theta1_vals));
for i = 1:length(theta0_vals)
    for j = 1:length(theta1_vals)
	  t = [theta0_vals(i); theta1_vals(j)];    
	  J_vals(i,j) = computeCost(X, y, t);
    end
end
J_vals = J_vals';
disp('J_vals set to transpose');

% Surface Plot
disp('Surface Plot displayed');
figure;
surf(theta0_vals, theta1_vals, J_vals)
xlabel('\theta_0'); ylabel('\theta_1');

% Contour Plot
disp('Contour Plot displayed');
figure;
contour(theta0_vals, theta1_vals, J_vals, logspace(-2, 3, 20))
xlabel('\theta_0'); ylabel('\theta_1');
hold on;
plot(theta(1), theta(2), 'rx', 'MarkerSize', 10, 'LineWidth', 2);
hold off;