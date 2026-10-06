# How to Link Local IntelliJ Project to GitHub

This guide explains the complete process of connecting your local IntelliJ IDEA project to a GitHub repository.

---

## Prerequisites

Before starting, ensure you have:

1. ✅ **Git installed** on your system
    - Download from: https://git-scm.com/download/win
    - Verify installation: Open Git Bash and run `git --version`

2. ✅ **IntelliJ IDEA** installed
    - Download from: https://www.jetbrains.com/idea/download

3. ✅ **GitHub account** created
    - Sign up at: https://github.com

4. ✅ **Repository created on GitHub**
    - Go to GitHub → Click "+" → "New repository"
    - Name it (e.g., `LearnTrack`)
    - Keep it Public
    - Don't initialize with README (we'll push from local)

---

## Step-by-Step Guide

### Step 1: Create New Project in IntelliJ

1. Open IntelliJ IDEA
2. **File → New → Project**
3. Select **Java** → Click **Next**
4. Uncheck "Create project from template" → Click **Next**
5. **Project name**: `LearnTrack`
6. **Location**: Choose a folder (e.g., `C:\Users\YourName\LearnTrack`)
7. Click **Finish**

---

### Step 2: Create Project Structure

Create your packages and files:
LearnTrack/
├── src/
│ └── com/
│ └── airtribe/
│ └── learntrack/
│ ├── entity/
│ ├── service/
│ ├── ui/
│ ├── exception/
│ └── util/
├── docs/
│ ├── Setup_Instructions.md
│ ├── JVM_Basics.md
│ └── Design_Notes.md
├── README.md
└── .gitignore

text

---

### Step 3: Configure Git Identity (One-Time Setup)

Open **Terminal** in IntelliJ (bottom tab or `Alt+F12`) and run:

```bash
# Set your Git username
git config --global user.name "Your Name"

# Set your Git email (same as GitHub account)
git config --global user.email "your.email@example.com"

# Verify
git config --list
```

---

### Step 4: Enable Git for Your Project

1. In IntelliJ, click **Git** (top menu) → **Create Git Repository**
2. Select your LearnTrack project folder
3. Click **OK**

Files in your project will now show colors:
- **Red**: Untracked files (not in Git yet)
- **Green**: Staged files (ready to commit)
- **Blue**: Modified files (already tracked)

---

### Step 5: Add Files to Git

1. Right-click on your LearnTrack project folder (in Project panel)
2. Select **Git → Add** (or press `Ctrl+Alt+A`)
3. All files turn **green** (staged for commit)

---

### Step 6: Make Initial Commit

1. Press `Ctrl+K` (or **Git → Commit**)
2. Enter commit message: `Initial LearnTrack project setup`
3. Click **Commit**

---

### Step 7: Link to GitHub Repository

#### Method A: Using Git Remotes (Recommended)

1. Click **Git → Remotes**
2. Click **+** (plus icon)
3. Enter:
    - **Name**: `origin`
    - **URL**: `https://github.com/USERNAME/REPOSITORY.git`
    - Example: `https://github.com/nramya186/learntrack.git`
4. Click **OK**

#### Method B: Using Terminal

Open Terminal in IntelliJ and run:

```bash
git remote add origin [https://github.com/USERNAME/REPOSITORY.git](https://github.com/USERNAME/REPOSITORY.git)
```

---

### Step 8: Push to GitHub

#### Method A: Using IntelliJ UI

1. Press `Ctrl+Shift+K` (or **Git → Push**)
2. Click **Push**

#### Method B: Using Terminal

```bash
# Rename branch to main
git branch -M main

# Push to GitHub
git push -u origin main
```

---

### Step 9: Authentication

When pushing for the first time, you'll be prompted for credentials:

**Option 1: Browser Authentication (Easiest)**
- Click the notification: "Complete authentication in your browser"
- Log in to GitHub in your browser
- Approve the connection

**Option 2: Personal Access Token**

If prompted for username/password:
- **Username**: Your GitHub username
- **Password**: Your GitHub Personal Access Token (NOT regular password)

**Create Personal Access Token:**
1. Go to: https://github.com/settings/tokens
2. Click **Generate new token (classic)**
3. Note: `LearnTrack Project`
4. Expiration: `90 days`
5. Select scopes: ✅ **repo** (full control)
6. Click **Generate token**
7. **COPY THE TOKEN** (save it securely - you can't see it again!)
8. Use this token as password when pushing

---

### Step 10: Verify on GitHub

1. Go to: `https://github.com/USERNAME/REPOSITORY`
2. Refresh the page
3. You should see all your files!

---

## Making Future Changes

After making changes to your code:

```bash
# 1. Add changed files
git add .

# 2. Commit with message
git commit -m "Add Student entity class"

# 3. Push to GitHub
git push
```

Or use IntelliJ shortcuts:
- `Ctrl+Alt+A` - Add files
- `Ctrl+K` - Commit
- `Ctrl+Shift+K` - Push

---

## Common Issues & Solutions

### Issue 1: "Git is not recognized"

**Solution:** Git is not in your PATH
- Use Git Bash instead of PowerShell
- Or add Git to PATH: `C:\Program Files\Git\bin`

### Issue 2: "Remote origin already exists"

**Solution:**
```bash
git remote remove origin
git remote add origin [https://github.com/USERNAME/REPOSITORY.git](https://github.com/USERNAME/REPOSITORY.git)
```

### Issue 3: "Authentication failed"

**Solution:** Use Personal Access Token instead of password

### Issue 4: "Updates were rejected because remote contains work"

**Solution:**
```bash
git pull origin main --allow-unrelated-histories
git push -u origin main
```

### Issue 5: "src refspec main does not match any"

**Solution:** You haven't made a commit yet
```bash
git add .
git commit -m "Initial commit"
git push -u origin main
```

---

## Git Commands Reference

| Command | Description |
|---------|-------------|
| `git init` | Initialize Git repository |
| `git status` | Check current status |
| `git add .` | Add all files to staging |
| `git commit -m "msg"` | Commit with message |
| `git remote add origin <url>` | Link to GitHub repo |
| `git remote -v` | View remotes |
| `git push -u origin main` | Push to GitHub |
| `git pull` | Pull changes from GitHub |
| `git log --oneline` | View commit history |
| `git branch -M main` | Rename branch to main |

---

## IntelliJ Git Shortcuts

| Shortcut | Action |
|----------|--------|
| `Ctrl+Alt+A` | Add files to Git |
| `Ctrl+K` | Commit changes |
| `Ctrl+Shift+K` | Push to remote |
| `Ctrl+T` | Pull from remote |
| `Alt+9` | View Git log |
| `Alt+F12` | Open Terminal |

---

## Best Practices

1. ✅ **Commit frequently** with meaningful messages
2. ✅ **Push regularly** to backup your work
3. ✅ **Use .gitignore** to exclude unnecessary files
4. ✅ **Keep repository public** for submission purposes
5. ✅ **Save your Personal Access Token** securely

---

## Complete Workflow Example

```bash
# 1. Navigate to project
cd /c/Users/YourName/LearnTrack

# 2. Configure Git (one-time)
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# 3. Initialize Git
git init

# 4. Add all files
git add .

# 5. Commit
git commit -m "Initial LearnTrack setup"

# 6. Link to GitHub
git remote add origin [https://github.com/USERNAME/REPOSITORY.git](https://github.com/USERNAME/REPOSITORY.git)

# 7. Set branch name
git branch -M main

# 8. Push to GitHub
git push -u origin main
```

---

## Verification Checklist

- [ ] Git installed and accessible
- [ ] IntelliJ project created
- [ ] Git repository initialized
- [ ] Files added and committed
- [ ] Remote origin configured
- [ ] Successfully pushed to GitHub
- [ ] Files visible on GitHub
- [ ] Personal Access Token saved securely

---

**Last Updated**: October 6, 2026  
**Author**: AmyRa




