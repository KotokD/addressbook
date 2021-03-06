package addressbook.generator;

import addressbook.model.GroupData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
  @Parameter(names = "-c" ,description = "Group count")
  public int count;

  @Parameter(names = "-f" ,description = "Target file")
  public String file;
  public static void main(String args[]) throws IOException {
    GroupDataGenerator generator=new GroupDataGenerator();
    JCommander jconmmander= new  JCommander(generator);
    try {
      jconmmander.parse(args);
    }
    catch (ParameterException ex)
    {
     jconmmander.usage();
     return;
    }
    generator.run();
    
  }
  private void run() throws IOException {
    List <GroupData> groups =generateGroups(count);
    save(groups,new File (file));
  }


  private  List<GroupData> generateGroups(int count)
  {
    List<GroupData> groups= new ArrayList<GroupData>();
    for(int i=0; i<count;i++)
    {
      groups.add(new GroupData().withName(String.format("TestFileGeneration %s",i)). withFooter(String.format("TestFileGeneration %s",i)).withHeader(String.format("TestFileGeneration %s",i)));
    }
    return groups;
  }
  private void save (List<GroupData> groups,File file) throws IOException {
    Writer writer =new FileWriter(file);
    for(GroupData group:groups)
    {
      writer.write(String.format("%s:%s:%s\n",group.getName(),group.getHeader(),group.getFooter()));

    }
    writer.close();

  }

}
