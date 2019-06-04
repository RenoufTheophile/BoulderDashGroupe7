import java.io.*;

public class Main {

    final static int SIZE_X = 22;
    final static int SIZE_Y = 42;

    private static File file;
    private static char[][] tab = new char[SIZE_X][SIZE_Y];

    public static void main (String[] args) {
        file = new File("D:\\CESI\\\\PROJET\\A1.1\\Projet Java\\4 (1).txt");
        try {
            readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "";
        for(int i = 0; i < SIZE_X; i++){
            for(int y = 0; y < SIZE_Y; y++){
                str += "INSERT INTO map (map_num, map_x, map_y, element) VALUES (" + 5 + "," + i + "," + y + ",'" + tab[i][y] + "');" + "\n";
            }
        }
        System.out.println(str);
    }

    public static void readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int cpt = 0;
        while ((line = br.readLine()) != null) {
            for(int i = 0; i < line.length(); i++){
                tab[cpt][i] = line.charAt(i);
            }
            cpt++;
        }
        br.close();
    }
}