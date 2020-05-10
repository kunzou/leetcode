import java.util.ArrayList;
import java.util.List;

public class AMZ_LinuxFindCommand {
}

class File {
  String name;
  int size;
  int type;
  boolean isDirectory;
  File[] children;
}

abstract class Filter {
  abstract boolean apply(File file);
}

class MinSizeFilter extends Filter {

  int minSize;

  public MinSizeFilter(int minSize) {
    this.minSize = minSize;
  }

  @Override
  boolean apply(File file) {
    return file.size > minSize;
  }
}

class TypeFilter extends Filter {

  int type;

  public TypeFilter(int type) {
    this.type = type;
  }

  @Override
  boolean apply(File file) {
    return file.type == type;
  }
}

class FindCommand {

  public List<File> findWithFilters(File directory, List<Filter> filters) {
    if (!directory.isDirectory) {
//      return new NotADirectoryException();
      throw  new RuntimeException("not a directory");
    }
    List<File> output = new ArrayList<>();
    findWithFilters(directory, filters, output);
    return output;
  }

  private void findWithFilters(File directory, List<Filter> filters, List<File> output) {
    if (directory.children == null) {
      return;
    }
    for (File file : directory.children) {
      if (file.isDirectory) {
        findWithFilters(file, filters, output);
      } else {
        boolean selectFile = true;
        for (Filter filter : filters) {
          if (!filter.apply(file)) {
            selectFile = false;
          }
        }
        if (selectFile) {
          output.add(file);
        }
      }
    }
  }
}












/*

interface Filter {
  List<AmazonFile> apply(List<AmazonFile> amazonFiles);
}

class AndFilter implements Filter {
  private Filter f1, f2;

  AndFilter(Filter f1, Filter f2) {
    this.f1 = f1;
    this.f2 = f2;
  }

  public List<AmazonFile> apply(List<AmazonFile> files) {
    return f2.apply(f1.apply(files));
  }
}

class OrFilter implements Filter {
  private Filter f1, f2;

  OrFilter(Filter f1, Filter f2) {
    this.f1 = f1;
    this.f2 = f2;
  }

  public List<AmazonFile> apply(List<AmazonFile> files) {
    List<AmazonFile> f1Result = f1.apply(files);
    List<AmazonFile> f2Result = f2.apply(files);

    for (AmazonFile file : f2Result) {
      if (!f1Result.contains(file))
        f1Result.add(file);
    }
    return f1Result;
  }
}

class NotFilter implements Filter {
  private Filter f;

  NotFilter(Filter f) {
    this.f = f;
  }

  public List<AmazonFile> apply(List<AmazonFile> files) {
    List<AmazonFile> result = f.apply(files);

    for (AmazonFile file : files) {
      if (result.contains(file))
        result.remove(file);
    }
    return result;
  }
}

class SizeFilter {
  int size;
  SizeFilter(int size) {
    this.size = size;
  }
  public List<AmazonFile> apply(List<AmazonFile> files) {
    List<AmazonFile> result = new ArrayList<>();
    for (AmazonFile file : files)
      if (file.size() == this.size) result.add(file);
    return result;
  }
}

class AmazonFile {
  String name;
  String path;
  String directory;
  int size;
}*/
