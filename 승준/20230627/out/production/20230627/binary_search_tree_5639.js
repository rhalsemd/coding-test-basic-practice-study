const readline = require("readline");

function getPostorder(preorder) {
  if (preorder.length <= 1) {
    return preorder;
  }

  let stack = [];
  let postorder = [];
  stack.push([preorder, false]);

  while (stack.length > 0) {
    const [nodes, visited] = stack.pop();

    if (visited) {
      postorder.push(nodes[0]);
    } else {
      const root = nodes[0];
      const left = nodes.slice(1).filter((node) => node < root);
      const right = nodes.slice(1).filter((node) => node > root);

      stack.push([nodes, true]);
      if (right.length > 0) {
        stack.push([right, false]);
      }
      if (left.length > 0) {
        stack.push([left, false]);
      }
    }
  }

  return postorder;
}

let preorder = [];
readline
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    preorder.push(parseInt(line));
  })
  .on("close", () => {
    const postorder = getPostorder(preorder);
    for (const node of postorder) {
      console.log(node);
    }
  });
