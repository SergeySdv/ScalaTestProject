import java.awt.event.{ActionEvent, ActionListener}

import javax.swing.JButton


// without implicit
val button = new JButton
button.addActionListener(
  (_: ActionEvent) => {
    println("pressed!")
  }
)

// implicitly

implicit def function2ActionListener(f: ActionEvent => Unit): ActionListener =
  (event: ActionEvent) => f(event)

button.addActionListener(
  function2ActionListener(
    (_: ActionEvent) => println("pressed!")
  )
)


button.addActionListener(
  (_: ActionEvent) => println("pressed!")
)
