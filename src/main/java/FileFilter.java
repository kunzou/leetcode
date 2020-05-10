import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

public interface FileFilter extends Predicate<LsEntry> {
  boolean accept(LsEntry sftpFile);
  @Override
  default boolean test(LsEntry lsEntry) {
    return accept(lsEntry);
  }
}

class OlderThanDaysFilter implements FileFilter {
  private final int days;

  public OlderThanDaysFilter(int days) {
    this.days = days;
  }

  @Override
  public boolean accept(LsEntry lsEntry) {
    return LocalDateTime.now().isAfter(lsEntry.getCreateDate());
  }
}


class LsEntry {
  private LocalDateTime createDate;

  public LocalDateTime getCreateDate() {
    return createDate;
  }
}

class NameSftpFileFilter implements FileFilter {

  private final String fileName;
  public NameSftpFileFilter(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public boolean accept(LsEntry sftpFile) {
    return false;
  }

  @Override
  public boolean test(LsEntry lsEntry) {
    return false;
  }
}

class Test {
  public void runner() {
    LsEntry lsEntry = new LsEntry();
    OlderThanDaysFilter olderThanDaysFilter = new OlderThanDaysFilter(5);
    olderThanDaysFilter.accept(lsEntry);
  }
}

class ConditionFactory {
  private static final FileFilter OLDER_THAN_TEN = new OlderThanDaysFilter(10);
  private static final FileFilter PASSWORDS_FILE = new NameSftpFileFilter("passwords.txt");

  public FileFilter createOlderThan10Days() {
    return OLDER_THAN_TEN;
  }

  public FileFilter createPasswordsFile() {
    return PASSWORDS_FILE;
  }

  public FileFilter createNameFilter(final String name) {
    return new NameSftpFileFilter(Objects.requireNonNull(name));
  }

  public FileFilter createOlderThan(final int days) {
    return new OlderThanDaysFilter(10);
  }
}