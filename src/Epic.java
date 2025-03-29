import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Subtask> subtasks;

    public Epic(String title, String description, int id) {
        super(title, description, id);
        subtasks = new ArrayList<>();
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void addSubtask(Subtask subtask) {
        this.subtasks.add(subtask);
    }

    public void removeSubtask(Subtask subtask) {
        this.subtasks.remove(subtask);
    }

    @Override
    public TaskStatus getStatus() {
        if (subtasks.isEmpty() || subtasks.stream().allMatch(subtask -> subtask.getStatus() == TaskStatus.NEW)) {
            return TaskStatus.NEW;
        } else if (subtasks.stream().allMatch(subtask -> subtask.getStatus() == TaskStatus.DONE)) {
            return TaskStatus.DONE;
        } else {
            return TaskStatus.IN_PROGRESS;
        }
    }
}
