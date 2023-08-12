import java.util.TreeMap;

class SnapshotArray {
    TreeMap<Integer, Integer>[] Tm;
    int snap_id = 0;

    public SnapshotArray(int length) {
        Tm = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            Tm[i] = new TreeMap<Integer, Integer>();
            Tm[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        Tm[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        return Tm[index].floorEntry(snap_id).getValue();
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(5);

        snapshotArray.set(0, 5);
        snapshotArray.set(1, 10);
        snapshotArray.snap(); // Snapshot 0
        snapshotArray.set(0, 6);
        snapshotArray.snap(); // Snapshot 1
        snapshotArray.set(1, 11);

        int snapId1 = snapshotArray.snap();
        int snapId2 = snapshotArray.snap();

        System.out.println("Value at index 0 in snapshot " + snapId1 + ": " + snapshotArray.get(0, snapId1)); // Output: 6
        System.out.println("Value at index 1 in snapshot " + snapId2 + ": " + snapshotArray.get(1, snapId2)); // Output: 11
    }
}
