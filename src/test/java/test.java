

import org.junit.jupiter.api.Test;

import java.io.IOException;
public class test {

    @Test
    public void test1() throws IOException {
        writeFormulasInToFile writeFormulasInToFile = new writeFormulasInToFile();
        writeFormulasInToFile.write(10, 10);
    }

    @Test
    public void test2(){
        comparetor comparetor = new comparetor();
        comparetor.compare();
    }

}
