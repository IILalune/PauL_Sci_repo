import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class HuffmanTree extends CodingTree {

    /**
     * Encodes the input file using Huffman coding.
     *
     * @param inputFile The file to encode.
     * @param outputFile The file to save the encoded data.
     * @param mapFile The file to save the character codes.
     * @throws IOException If there is a problem with the files.
     */
    @Override
    public void encodeFile(String inputFile, String outputFile, String mapFile)
            throws IOException {

        // 1. Read the input file
        String text = new String(Files.readAllBytes(Paths.get(inputFile)));

        // 2. Count the frequency of each character
        Map<Character, Integer> frequency = new HashMap<>();

        for (char letter : text.toCharArray()) {
            if (frequency.containsKey(letter)) {
                int f = frequency.get(letter);
                f++;
                frequency.replace(letter, f);
            } else {
                frequency.put(letter, 1);
            }
        }

        // 3. Build the Huffman tree
        root = buildTree(frequency);

        charToCode.clear();
        codeToChar.clear();

        // 4. Generate the Huffman codes
        if (root != null) {
            generateCodes(root, "");
        }

        // 5. Encode the original text
        StringBuilder encoded = new StringBuilder();

        for (char letter : text.toCharArray()) {
            encoded.append(charToCode.get(letter));
        }

        // 6. Write the character codes to the map file
        writeMapFile(mapFile, encoded.length());

        // 7. Write the encoded data
        writeEncodedFile(encoded.toString(), outputFile);

        System.out.println("Encoding complete: " + outputFile);
        System.out.println("Mapping file: " + mapFile);
        System.out.println("Original characters: " + text.length());
        System.out.println("Valid encoded bits: " + encoded.length());
    }


    /**
     * Decodes the encoded file back into the original text.
     *
     * @param inputFile The encoded file.
     * @param outputFile The file to save the decoded text.
     * @param mapFile The file containing the character codes.
     * @throws IOException If there is a problem with the files.
     */
    @Override
    public void decodeFile(String inputFile, String outputFile, String mapFile)
            throws IOException {

        charToCode.clear();
        codeToChar.clear();

        // 1. Read the character codes
        readMapFile(mapFile);

        // 2. Read the encoded data
        String encoded = readEncodedFile(inputFile);

        // 3. Decode the data
        StringBuilder decoded = new StringBuilder();
        String currentCode = "";

        for (char bit : encoded.toCharArray()) {
            currentCode += bit;

            if (codeToChar.containsKey(currentCode)) {
                decoded.append(codeToChar.get(currentCode));
                currentCode = "";
            }
        }

        // 4. Make sure there are no incomplete codes
        if (!currentCode.isEmpty()) {
            throw new IOException("Invalid Huffman encoded file.");
        }

        // 5. Write the decoded text
        Files.write(Paths.get(outputFile), decoded.toString().getBytes());

        System.out.println("Decoding complete: " + outputFile);
        System.out.println("Decoded characters: " + decoded.length());
    }


    /**
     * Builds the Huffman tree using the character frequencies.
     *
     * @param frequency The frequency of each character.
     * @return The root of the Huffman tree.
     */
    private HuffmanNode buildTree(Map<Character, Integer> frequency) {

        if (frequency.isEmpty()) {
            return null;
        }

        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();

        // Create a node for each character
        for (Character letter : frequency.keySet()) {
            int f = frequency.get(letter);
            HuffmanNode node = new HuffmanNode(letter, f);
            queue.add(node);
        }

        // Combine the two smallest nodes
        while (queue.size() > 1) {
            HuffmanNode left = queue.remove();
            HuffmanNode right = queue.remove();

            int newFrequency = left.getFreq() + right.getFreq();
            HuffmanNode parent = new HuffmanNode(newFrequency, left, right);

            queue.add(parent);
        }

        // The last node is the root
        return queue.remove();
    }


        // Missing solutions.... to be filled with hint above. 
    }


}