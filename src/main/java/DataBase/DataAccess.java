package DataBase;


import Entities.CommentList;
import UseCase.Gateway;

import java.io.*;

public class DataAccess implements Gateway ,Serializable{
    private String fileName;

    public DataAccess(String fileName){
        this.fileName = fileName;

    }


    /**
     * @return CommentList
     * @throws IOException
     * @throws ClassNotFoundException
     *
     * read file and return a Comment to interactor if there is already comment list saved.
     * else make a empty comment list and return that.
     */
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

    /**
     * @param commentList
     * @throws IOException
     * Save any changes to the file as a binary code
     */
    @Override
    public void saveComment(CommentList commentList) throws IOException {

        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
        outputStream.writeObject(commentList);
        fileOut.close();



    }


}
