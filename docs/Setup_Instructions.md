## Learn Track Setup Instructions

JDK Version Used
-  **JDK Version Used ** :java 25.0.2  (Java Development Kit)
-  **Vendor ** Oracle OpenJDK
-  **Installation Date: 2026-01-20

## Instalation steps

### Step 1: Download JDK
1. Visit [Oracel JDK Download]
   (https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://jdk.java.net/)
2. Download JDK 25 for Operating System (Windows/Mac/Linux)
3. Run the installer and follow the setup wizard

### Step 2: Set JAVA_HOME Environment Variable
**Windows:**
1.Right-click on "This PC" → Properties
2.Click "Advanced system settings"
3.Click "Environment Variables"
4.Under "System variables", click "New"
5.Variable name: JAVA_HOME
6.Variable value: C:\Program Files\Java\jdk-17
7.Click OK

### Step 3: Verify Installation
Open terminal/command prompt and run:
```bash
java -version
javac -version '''
## Hello World Program

### Step 1: Create the File
Create a file named `HelloWorld.java`:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, LearnTrack!");
    }
}
```

### Step 2: Compile the Program
Open terminal in the file's directory and run:
```bash
javac HelloWorld.java
```

This creates `HelloWorld.class` (bytecode file).

### Step 3: Run the Program
```bash
java HelloWorld
```

### Expected Output
Hello, LearnTrack!

text

### Screenshot Reference
Terminal Output:
┌─────────────────────────────────────────┐
│ $ javac HelloWorld.java │
│ $ java HelloWorld │
│ Hello, LearnTrack! │
│ │
│ $ java -version │
│ java version "25.0.2" 2026-01-20 LTS │
└─────────────────────────────────────────┘

text

## Troubleshooting

### Common Issues

**Issue 1: "javac: command not found"**
- Solution: Ensure JDK (not just JRE) is installed and JAVA_HOME is set correctly

**Issue 2: "Error: Could not find or load main class"**
- Solution: Make sure you're in the correct directory and class name matches filename

**Issue 3: Version mismatch**
- Solution: Run `echo $JAVA_HOME` (Mac/Linux) or `echo %JAVA_HOME%` (Windows) to verify path

## IDE Setup (Optional)

### IntelliJ IDEA
1. Download from [jetbrains.com](https://www.jetbrains.com/idea/)
2. Install and open
3. File → New → Project → Select JDK 25
4. Create package: `com.airtribe.learntrack`

### Eclipse
1. Download from [eclipse.org](https://www.eclipse.org/downloads/)
2. Install Eclipse IDE for Java Developers
3. Window → Preferences → Java → Installed JREs → Add JDK 25

---
**Last Updated**: October 4, 2026
**Author**: LearnTrack Team
