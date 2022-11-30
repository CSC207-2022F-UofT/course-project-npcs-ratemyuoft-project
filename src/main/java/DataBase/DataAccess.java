package DataBase;

import Entities.Comment;
import Entities.CommentList;
import UseCase.Gateway;

import java.io.*;

public class DataAccess implements Gateway ,Serializable{
    private String fileName;

    public DataAccess(String fileName){
        this.fileName = fileName;

    }



    @Override

    public CommentList importComment() throws IOException, ClassNotFoundException {


        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
            }catch (EOFException e){
            CommentList newCL = new CommentList();
            this.saveComment(newCL);
        }
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if (br.readLine() == null) {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(new CommentList());
        }

        CommentList newComments = (CommentList) inputStream.readObject();
        return newComments;

    }

    @Override
    public void saveComment(CommentList commentList) throws IOException {

        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
        outputStream.writeObject(commentList);
        fileOut.close();



    }
}
