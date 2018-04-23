package co.erizocosmi;

import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void shouldFail() {
        try {
            File dir = new File(App.class.getResource("/repository").getFile());
            Repository repository = new RepositoryBuilder()
                    .setGitDir(dir)
                    .build();

            byte[] content = repository.newObjectReader()
                    .open(ObjectId.fromString("bd7cb56b3bc934acda47089175733f625c6cdb37"))
                    .getBytes();

            System.out.println(content.length + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
