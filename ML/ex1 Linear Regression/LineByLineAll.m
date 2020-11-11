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

