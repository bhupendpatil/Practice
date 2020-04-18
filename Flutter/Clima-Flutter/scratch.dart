void main() {
  performTasks();
}

void performTasks() async {
  task1();
  String task2Data = await task2();
  task3(task2Data);
}

void task1() {
  String result = 'task 1 data';
  print('$result complete');
}

Future<String> task2() async {
  Duration threeSecs = Duration(seconds: 3);

  String result;

  await Future.delayed(threeSecs, () {
    result = 'task 2 data';
    print('Task 2 complete');
  });

  return result;
}

void task3(String task2Data) {
  String result = 'task 3 data';
  print('$result complete with $task2Data');
}
