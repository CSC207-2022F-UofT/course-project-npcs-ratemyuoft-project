package commentDataBase;


import entities.CommentList;
import commentUseCase.commentGateway;

import java.io.*;

public class commentDataAccess implements commentGateway,Serializable{
    ObjectInputStream inputStream;
    private final String fileName;

    public commentDataAccess(String fileName){
        this.fileName = fileName;

    }


    /**
     * @return CommentList
     * @throws IOException import fails
     * @throws ClassNotFoundException
     *
     * read file and return a Comment to interactor if there is already comment list saved.
     * else make an empty comment list and return that.
     */
    @Override

    public CommentList importComment() throws IOException, ClassNotFoundException {


        try {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
            }catch (EOFException e){
            CommentList newCL = new CommentList();
            this.saveComment(newCL);
        }
        inputStream = new ObjectInputStream(new FileInputStream(fileName));
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        if (br.readLine() == null) {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(new CommentList());
        }
        return (CommentList) inputStream.readObject();

    }

    /**
     * @param  commentList it takes in
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
