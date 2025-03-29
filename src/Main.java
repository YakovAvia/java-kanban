public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("Задача 1", "Описание задачи 1", taskManager.generateId());
        Task task2 = new Task("Задача 2", "Описание задачи 2", taskManager.generateId());
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        Epic epic1 = new Epic("Эпик 1", "Описание эпика 1", taskManager.generateId());
        taskManager.addEpic(epic1);

        Subtask subtask1 = new Subtask("Подзадача 1", "Описание подзадачи 1",  taskManager.generateId(), epic1.getId());
        Subtask subtask2 = new Subtask("Подзадача 2", "Описание подзадачи 2",  taskManager.generateId(), epic1.getId());
        taskManager.addSubtask(subtask1);
        taskManager.addSubtask(subtask2);

        Epic epic2 = new Epic("Эпик 2", "Описание эпика 2", taskManager.generateId());
        taskManager.addEpic(epic2);

        Subtask subtask3 = new Subtask("Подзадача 3", "Описание подзадачи 3",  taskManager.generateId(), epic2.getId());
        taskManager.addSubtask(subtask3);

        System.out.println("Все задачи:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nВсе эпики:");
        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\nВсе подзадачи:");
        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.DONE);

        System.out.println("\nСтатус задач после изменений:");
        System.out.println(task1);
        System.out.println(task2);

        System.out.println("\nСтатус эпика 1: " + epic1.getStatus());

        System.out.println("Статус эпика 2: " + epic2.getStatus());

        taskManager.removeTask(task1.getId());
        taskManager.removeEpic(epic2.getId());

        System.out.println("\nПосле удаления задачи и эпика:");

        System.out.println("Все задачи:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nВсе эпики:");
        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }

        System.out.println("\nВсе подзадачи:");
        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }
    }
}