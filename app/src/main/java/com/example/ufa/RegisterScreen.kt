package com.example.ufa

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ufa.ui.components.UfaPrimaryButton
import com.example.ufa.ui.components.UfaTextField
import com.example.ufa.ui.theme.UfaTheme

@Composable
fun RegisterScreen(
    onBackClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isStudent by remember { mutableStateOf(true) }
    var accepted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        IconButton(onClick = onBackClick) {
            Icon(painterResource(R.drawable.ic_arrow_back), contentDescription = "Back")
        }

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(stringResource(R.string.register_title), fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Text(stringResource(R.string.register_subtitle), color = MaterialTheme.colorScheme.onSurfaceVariant)
        }

        // Role selector (Figma: segmented control)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(4.dp)
        ) {
            RoleOption(stringResource(R.string.role_student), isStudent, Modifier.weight(1f)) { isStudent = true }
            RoleOption(stringResource(R.string.role_host), !isStudent, Modifier.weight(1f)) { isStudent = false }
        }

        UfaTextField(stringResource(R.string.full_name), name, { name = it }, "Bruno Queiroz", R.drawable.ic_person)
        UfaTextField(stringResource(R.string.email), email, { email = it }, "you@griffith.ie", R.drawable.ic_mail, keyboardType = KeyboardType.Email)
        UfaTextField(stringResource(R.string.phone), phone, { phone = it }, "+353 87 123 4567", R.drawable.ic_phone, keyboardType = KeyboardType.Phone)
        UfaTextField(stringResource(R.string.password), password, { password = it }, "At least 8 characters", R.drawable.ic_lock, isPassword = true)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = accepted, onCheckedChange = { accepted = it })
            Text(stringResource(R.string.terms), color = MaterialTheme.colorScheme.onSurfaceVariant)
        }

        UfaPrimaryButton(text = stringResource(R.string.create_account), onClick = onRegisterClick)

        Spacer(Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(stringResource(R.string.have_account) + " ", color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(
                stringResource(R.string.log_in),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onLoginClick() }
            )
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun RoleOption(text: String, selected: Boolean, modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(9.dp))
            .background(if (selected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceVariant)
            .clickable { onClick() }
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = if (selected) FontWeight.Medium else FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    UfaTheme { RegisterScreen({ }, { }, { }) }
}