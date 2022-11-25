import DataBase.DataAccess;
import Entities.CommentList;

import java.io.*;

import Entities.CommentList;
import UseCase.Gateway;

public class TestForFile {

    public static class Testing {
        private static final String fileName = "commentsFile.sav";


        public CommentList importComment() throws IOException, ClassNotFoundException {

            FileInputStream fileIn = new FileInputStream(fileName);
            try {
                ObjectInputStream inputStream = new ObjectInputStream(fileIn);
            } catch (EOFException e) {
                CommentList newCL = new CommentList();
                this.saveComment(newCL);
            }
            ObjectInputStream inputStream = new ObjectInputStream(fileIn);

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            if (br.readLine() == null) {
                FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
                outputStream.writeObject(new CommentList());
            }

            CommentList newComments = (CommentList) inputStream.readObject();
            return newComments;

        }


        public void saveComment(CommentList commentList) throws IOException {

            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(commentList);
            fileOut.close();


        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Testing testing = new Testing();
        testing.importComment();


    }
}