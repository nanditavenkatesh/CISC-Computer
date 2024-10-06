# Team 7 Machine Simulator

## Overview
The Machine Simulator is a project designed to simulate a conventional CISC (Complex Instruction Set Computer) architecture. Developed in Java, the simulator mimics a basic computer system, complete with General Purpose Registers (GPRs), Index Registers (IXRs), memory, and a control unit. The project was built as part of CSCI 6461 - Computer System Architecture, Fall 2022, under the supervision of Professor Morris Lancaster.

## Features
- **Registers and Memory:** 
  - 4 General Purpose Registers (GPRs) of 16-bit length: `[R0, R1, R2, R3]`
  - 3 Index Registers (IXRs) of 16-bit length: `[X1, X2, X3]`
  - Program Counter (PC), Memory Address Register (MAR), Memory Buffer Register (MBR), Instruction Register (IR), and Machine Fault Register (MFR).
  - Memory of 2048 words, expandable up to 4096 words.
- **Assembly Instructions Supported:**
  - Load (LDR), Store (STR), Arithmetic and Logical operations (e.g., ADD, SUB, AND, ORR), Jump instructions (e.g., JZ, JMA), and special instructions (e.g., TRAP, HALT).
  - Floating point and vector instructions are also supported.
- **GUI Interface:**
  - Interactive GUI that allows users to load and store data, execute programs, and view the status of registers and memory.
  - Functional buttons like **RUN**, **SS (Single Step)**, **HALT**, **INIT**, **LD (Load)**, and **STORE** to manage the simulation process.

## Getting Started
### Prerequisites
- **Java Version**: Ensure you have Java SE 1.8 or higher installed. If not, you can download it from [Java Official Website](https://www.java.com/en/).

### Installation
1. **Download the Project**
   - Download the zip file containing the source code, executable JAR file, and necessary documents from the provided source.
   - Unzip the file and navigate to the project folder.

2. **Run the Simulator**
   - On **Windows**: Simply double-click on the `CSCI Project Team 7/src/RunnableJarFileTeam7Part4.jar` file.
   - On **non-Windows systems**: Use the terminal to run the JAR file with the command:
     ```sh
     java -jar RunnableJarFileTeam7Part4.jar
     ```

## Usage Instructions
### Starting the Simulator
- Launch the executable JAR file to open the Machine Simulator GUI.
- The main GUI is divided into sections for **Registers**, **Control Area**, and **Instruction Input**.

### Executing Programs
1. **Initialization**
   - Click the **INIT** button to initialize memory and registers.
   - Use the **IPL** button to load programs from a text file. The text file should contain memory address-value pairs in hexadecimal format.
2. **Running the Program**
   - Use **LD** buttons to load the Program Counter (PC) or Memory Address Register (MAR) as needed.
   - Click on **RUN** to execute all instructions or use **SS** (Single Step) to execute one instruction at a time.
   - To halt the simulator, click on the **HALT** button.
3. **Loading and Storing Data**
   - Use the **LD** button to load data to registers or memory.
   - Use **STORE** or **S+** to save data into memory.
   - **S+** automatically increments the memory address for repeated storage operations.

### Input/Output Operations
- The **IN** and **OUT** commands allow input from the console keyboard and output to the console printer.
- **CHK** command checks the status of different devices connected to the system.

## Functionalities Included
- **Arithmetic and Logical Operations**: Perform basic arithmetic (addition, subtraction) and logical (AND, OR, NOT) operations using GPRs.
- **Transfer Instructions**: Includes instructions like `JZ`, `JMA`, `JSR` for conditional and unconditional jumps.
- **Machine Fault Handling**: Machine Fault Register (MFR) indicates conditions such as illegal memory access, trap codes, or unimplemented operations.
- **Special Instructions**:
  - `TRAP`: System call handler that redirects execution based on a trap table.
  - `CHK`: Check the status of input/output devices.

## Examples of Usage
### Example Program 1: Floating Point Operations
1. **Load Floating Point Value**: Use `LDFR` instruction to load values into floating point registers (FR0, FR1).
2. **Add Values**: Execute `FADD` to add values from memory to floating point registers.
3. **Store Results**: Use `STFR` to save the results back into memory.

### Example Program 2: Paragraph Search
- The simulator includes a sample program that takes a paragraph as input, searches for a specific word, and displays the location of the word within the paragraph.
- Load the program using the **IPL** button and follow on-screen prompts to input the paragraph and search word.

## Project Structure
- **Source Code**: Divided into multiple packages for better readability:
  - `components` (Registers, Memory, etc.)
  - `main` (Main simulator logic)
  - `utils` (Utility functions)
- **Documentation**:
  - Detailed **Design Notes** and **User Manual** are included for reference.
  - Example program files (`program1.txt`, `program2.txt`) for testing.

## Team Members
- Nandita Venkatesh
- Harshini Mandalapu
- Shirish Inamdar

## Contributing
If you wish to contribute to this project, please follow these steps:
1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature/NewFeature`).
3. Commit your changes (`git commit -m 'Add some NewFeature'`).
4. Push to the branch (`git push origin feature/NewFeature`).
5. Open a pull request.

## Acknowledgements
- Professor Morris Lancaster for guiding us through the course and project requirements.
- CSCI 6461 - Computer System Architecture, Fall 2022.

## Contact
For any questions or suggestions, feel free to reach out via GitHub or contact any of the team members listed above.
