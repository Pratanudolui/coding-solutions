import java.io.*;
import java.util.*;

// Base or common money class / interface representing attributes and methods
abstract class Money {
    int val;

    public void setvalue(int val) {
        this.val = val;
    }

    public abstract void Display();
}

class Coin extends Money {
    @Override
    public void Display() {
        System.out.println(val);
    }
}

class Note extends Money {
    @Override
    public void Display() {
        System.out.println(val);
    }
}

// Generic Bag class to store and display items
class Bag<T extends Money> {
    private List<T> items = new ArrayList<>();

    public void add(T t) {
        items.add(t);
    }

    public void displayAll() {
        for (T item : items) {
            item.Display();
        }
    }
}

public class TestClass {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());

        Bag<Coin> coinBag = new Bag<>();
        Bag<Note> noteBag = new Bag<>();

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            String type = st.nextToken();
            int val = Integer.parseInt(st.nextToken());

            if (type.equals("Coin")) {
                Coin c = new Coin();
                c.setvalue(val);
                coinBag.add(c);
            } else if (type.equals("Note")) {
                Note note = new Note();
                note.setvalue(val);
                noteBag.add(note);
            }
        }

        System.out.println("Coins :");
        coinBag.displayAll();

        System.out.println("Notes :");
        noteBag.displayAll();
    }
}
