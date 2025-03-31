package task;

public class Subtask extends Task {

    private int epicId; // ID эпика, к которому относится подзадача

    public Subtask(String title, String description, int id, int epicId) {
        super(title, description, id);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }
}

