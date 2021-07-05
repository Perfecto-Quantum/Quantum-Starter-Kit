document.AxeResultHandler = function(axeResults, type) {
  this.nextIssue = function() {
    curIssue = null;
    curIssueNodeIdx = 0;
 
    if (axeResults[type].length === issueIdx) {
      return curIssue;
    }
    curIssue = axeResults[type][issueIdx++];
 
    return curIssue;
  }
 
  this.nextNodeFromCurrentIssue = function() {
    if (curIssue === null) {
      throw 'Invalid state - no current issue to work from.';
    }
 
    curIssueNode = null;
    if (curIssue.nodes.length === curIssueNodeIdx) {
      return curIssueNode;
    }
 
    curIssueNode = curIssue.nodes[curIssueNodeIdx++];
    curIssueNodeTargetIdx = 0;
 
    return curIssueNode;
  }
 
  this.nextTargetFromCurrentNode = function() {
    if (curIssueNode === null) {
      throw 'Invalid state - no current issue node to work from.';
    }
 
    curIssueNodeTarget = null;
    if (curIssueNode.target.length === curIssueNodeTargetIdx) {
      return curIssueNodeTarget;
    }
    curIssueNodeTarget = curIssueNode.target[curIssueNodeTargetIdx++];
 
    return curIssueNodeTarget;
  }
 
  this.highlightCurrentTarget = function() {
    highlighter.style.display = 'none';
    if (curIssueNodeTarget === null) {
      return;
    }
 
    console.log(curIssueNodeTarget);
    var element = document.querySelector(curIssueNodeTarget);
    if (!element) {
      console.warn("Axe selector target did not match an element in the document!");
      return;
    }
 
    window.scrollTo(0, 0);
    var rect = element.getBoundingClientRect();
 
    highlighter.style.display = 'block';
    highlighter.style.top = '' + rect.top + 'px';
    highlighter.style.left = '' + rect.left + 'px';
    highlighter.style.width = '' + rect.width + 'px';
    highlighter.style.height = '' + rect.height + 'px';
 
    highlighter.scrollIntoView(false);
  }
 
  this.getNodeAndTargetDetails = function() {
	  return {
		  'issue': curIssue.id,
		  'node': curIssueNode,
		  'target': curIssueNodeTarget
	  };
  } 
  
  // Setup
  var highlighter = document.getElementById('perfecto-axe-highlighter');
  if (!highlighter) {
    console.log('creating highlighter!');
    highlighter = document.createElement('div');
    highlighter.id = 'perfecto-axe-highlighter';
    highlighter.style.position = 'fixed';
    highlighter.style.top = '100';
    highlighter.style.left = '100';
    highlighter.style.width = '100';
    highlighter.style.height = '1000';
    highlighter.style.zIndex = "9999";
    highlighter.style.display = "none";
    document.getElementsByTagName('body')[0].appendChild(highlighter);
  }
  
  switch (type) {
	case 'violations':
		highlighter.style.border = "thick dotted magenta";
		break;
	case 'inapplicable':
		highlighter.style.border = "thick dotted orange";
		break;
	case 'passes':
		highlighter.style.border = "thick dotted green";
		break;
	default:
		console.warn("Unknown type: " + type + "defaulting to 'violations');");
		type = 'violations';
  }
 
  var issueIdx = 0;
  var curIssue = null;
  var curIssueNodeIdx = 0;
  var curIssueNode = null;
  var curIssueNodeTargetIdx = 0;
  var curIssueNodeTarget = null;
}
 
document.AxeResultHelper = function(result, type) {
  var rh = new document.AxeResultHandler(result, type);
  rh.nextIssue();
  rh.nextNodeFromCurrentIssue();
 
  this.highlightNext = function() {
	  
    if (rh.nextTargetFromCurrentNode()) {
      rh.highlightCurrentTarget();
      
      return JSON.stringify(rh.getNodeAndTargetDetails());
    }
 
    if (rh.nextNodeFromCurrentIssue()) {
      if (rh.nextTargetFromCurrentNode()) {
        rh.highlightCurrentTarget();

        return JSON.stringify(rh.getNodeAndTargetDetails());
      }
    }
 
    if (rh.nextIssue()) {
      if (rh.nextNodeFromCurrentIssue()) {
        if (rh.nextTargetFromCurrentNode()) {
          rh.highlightCurrentTarget();

          return JSON.stringify(rh.getNodeAndTargetDetails());
        }
      }
    }
    
    return null;
  }
}

return true;