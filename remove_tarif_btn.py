import os
import glob
import re

view_dir = r"c:\Users\DELL\OneDrive\Documents\NetBeansProjects\tugasakhir\src\main\java\com\mycompany\tugasakhir\view"

# Regex to find <Component class="javax.swing.JButton" name="btnTarif"> ... </Component> in XML
form_pattern = re.compile(r'<Component class="javax\.swing\.JButton" name="btnTarif">.*?</Component>', re.DOTALL)
# Regex for itemTarif in Java
java_itemtarif = re.compile(r'\s*JMenuItem itemTarif = new JMenuItem\("Tarif Parkir"\);\s*itemTarif\.addActionListener\(e -> showCard\("TARIF"\)\);\s*')
java_itemtarif_add = re.compile(r'\s*menuMasterData\.add\(itemTarif\);\s*')

for fpath in glob.glob(os.path.join(view_dir, "*.form")):
    with open(fpath, 'r', encoding='utf-8') as f:
        content = f.read()
    
    new_content = form_pattern.sub('', content)
    if new_content != content:
        with open(fpath, 'w', encoding='utf-8') as f:
            f.write(new_content)
        print(f"Updated {fpath}")

for fpath in glob.glob(os.path.join(view_dir, "*.java")):
    with open(fpath, 'r', encoding='utf-8') as f:
        lines = f.readlines()
    
    new_lines = []
    for line in lines:
        if 'btnTarif' in line and 'JButton[] buttons' in line:
            line = line.replace('btnTarif, ', '').replace(', btnTarif', '')
        if 'btnTarif.addActionListener' in line:
            continue
        if 'btnTarif.setVisible' in line:
            continue
        if 'btnTarif = new javax.swing.JButton();' in line:
            continue
        if 'btnTarif.setText("Kelola Tarif");' in line:
            continue
        if 'sidebarPanel.add(btnTarif, gridBagConstraints);' in line:
            continue
        if 'private javax.swing.JButton btnTarif;' in line:
            continue
        if '"TARIF"' in line and 'cards' in line:
            line = line.replace('"TARIF", ', '').replace(', "TARIF"', '')
        new_lines.append(line)
        
    content = "".join(new_lines)
    content = java_itemtarif.sub('', content)
    content = java_itemtarif_add.sub('', content)
    
    with open(fpath, 'w', encoding='utf-8') as f:
        f.write(content)
    print(f"Updated {fpath}")
